package oit.is.t5.poketmoneybook.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import oit.is.t5.poketmoneybook.model.Kind;
import oit.is.t5.poketmoneybook.model.KindMapper;
import oit.is.t5.poketmoneybook.model.Type;
import oit.is.t5.poketmoneybook.model.TypeMapper;
import oit.is.t5.poketmoneybook.model.Record;
import oit.is.t5.poketmoneybook.model.RecordMapper;
import oit.is.t5.poketmoneybook.model.Statistics;
import oit.is.t5.poketmoneybook.model.StatisticsMapper;

@Controller
@RequestMapping("/Statistics")
public class StatisticsController {
  @Autowired
  StatisticsMapper statisticsMapper;

  int month;
  int year2;

  @GetMapping
  public String statistics(ModelMap model, Principal prin) {
    LocalDateTime nowDate = LocalDateTime.now();
    DateTimeFormatter YearFormat = DateTimeFormatter.ofPattern("yyyy");
    DateTimeFormatter MonthFormat = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter DayFormat = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    int user_id = Integer.parseInt(prin.getName());
    int sumSpending = 0;
    int sumIncome = 0;

    int Year = Integer.parseInt(nowDate.format(YearFormat));
    int Month = Integer.parseInt(nowDate.format(MonthFormat));
    int Day = Integer.parseInt(nowDate.format(DayFormat));
    String date = nowDate.format(DateFormat);
    String ym = String.format(date.substring(0, 7) + "-%%");
    String info = date.substring(0, 7);
    model.addAttribute("this", info);

    year2 = Year;
    month = Month;

    ArrayList<Record> record = statisticsMapper.selectAllRecord(user_id);

    for (int i = 0; i < record.size(); i++) {
      int year, month;
      year = Integer.parseInt(record.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(record.get(i).getDate().substring(5, 7));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month && record.get(i).getStatus() == 0) {
        sumSpending += record.get(i).getValue();
      }
    }
    model.addAttribute("sumS", sumSpending);

    ArrayList<Statistics> type = statisticsMapper.selectTypeRecord(user_id, ym);
    model.addAttribute("type", type);

    ArrayList<Statistics> kind = statisticsMapper.selectKindRecord(user_id, ym);
    model.addAttribute("kind", kind);

    for (int i = 0; i < record.size(); i++) {
      int year, month;
      year = Integer.parseInt(record.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(record.get(i).getDate().substring(5, 7));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month && record.get(i).getStatus() == 1) {
        sumIncome += record.get(i).getValue();
      }
    }
    model.addAttribute("sumI", sumIncome);

    int BoP = sumIncome - sumSpending;
    double ratio = (double) Math.round(((double) sumSpending / (double) sumIncome) * 1000) / 10;
    System.out.println("ratio:" + ratio);

    model.addAttribute("BoP", BoP);
    model.addAttribute("ratio", ratio);

    int sumSpending2 = 0;
    int sumIncome2 = 0;

    ArrayList<Record> allS = statisticsMapper.selectOtherSumSRecord(user_id, ym);
    ArrayList<Record> allI = statisticsMapper.selectOtherSumIRecord(user_id, ym);
    for (int i = 0; i < allS.size(); i++) {
      sumSpending2 += allS.get(i).getValue();
    }
    for (int i = 0; i < allS.size(); i++) {
      sumIncome2 += allI.get(i).getValue();
    }

    double ratio2 = (double) Math.round(((double) sumSpending2 / (double) sumIncome2) * 1000) / 10;
    model.addAttribute("ratio2", ratio2);

    return "statistics.html";
  }

  @PostMapping
  public String statistics(@RequestParam Boolean submit1, ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());

    if (submit1)
      month--;
    if (!submit1)
      month++;

    if (month == 0) {
      year2--;
      month = 12;
    }
    if (month == 13) {
      year2++;
      month = 1;
    }

    int sumSpending = 0;
    int sumIncome = 0;

    int Year = year2;
    int Month = month;
    String date = String.format("%d-%02d-01", Year, Month);
    String ym = String.format(date.substring(0, 7) + "-%%");
    String info = date.substring(0, 7);
    model.addAttribute("this", info);

    month = Month;

    ArrayList<Record> record = statisticsMapper.selectAllRecord(user_id);

    for (int i = 0; i < record.size(); i++) {
      int year, month;
      year = Integer.parseInt(record.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(record.get(i).getDate().substring(5, 7));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month && record.get(i).getStatus() == 0) {
        sumSpending += record.get(i).getValue();
      }
    }
    model.addAttribute("sumS", sumSpending);

    ArrayList<Statistics> type = statisticsMapper.selectTypeRecord(user_id, ym);
    model.addAttribute("type", type);

    ArrayList<Statistics> kind = statisticsMapper.selectKindRecord(user_id, ym);
    model.addAttribute("kind", kind);

    for (int i = 0; i < record.size(); i++) {
      int year, month;
      year = Integer.parseInt(record.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(record.get(i).getDate().substring(5, 7));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month && record.get(i).getStatus() == 1) {
        sumIncome += record.get(i).getValue();
      }
    }
    model.addAttribute("sumI", sumIncome);

    int BoP = sumIncome - sumSpending;
    double ratio = (double) Math.round(((double) sumSpending / (double) sumIncome) * 1000) / 10;
    System.out.println("ratio:" + ratio);

    model.addAttribute("BoP", BoP);
    model.addAttribute("ratio", ratio);

    int sumSpending2 = 0;
    int sumIncome2 = 0;

    ArrayList<Record> allS = statisticsMapper.selectOtherSumSRecord(user_id, ym);
    ArrayList<Record> allI = statisticsMapper.selectOtherSumIRecord(user_id, ym);
    for (int i = 0; i < allS.size(); i++) {
      sumSpending2 += allS.get(i).getValue();
    }
    for (int i = 0; i < allS.size(); i++) {
      sumIncome2 += allI.get(i).getValue();
    }

    double ratio2 = (double) Math.round(((double) sumSpending2 / (double) sumIncome2) * 1000) / 10;
    model.addAttribute("ratio2", ratio2);
    return "statistics.html";
  }
}
