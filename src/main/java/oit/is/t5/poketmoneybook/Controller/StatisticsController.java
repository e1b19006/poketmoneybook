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

  @GetMapping
  public String statistics(ModelMap model, Principal prin) {
    LocalDateTime nowDate = LocalDateTime.now();
    DateTimeFormatter YearFormat = DateTimeFormatter.ofPattern("yyyy");
    DateTimeFormatter MonthFormat = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter DayFormat = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter DateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    int user_id = Integer.parseInt(prin.getName());
    int sumU = 0;
    int sumD = 0;
    int sumM = 0;

    int Year = Integer.parseInt(nowDate.format(YearFormat));
    int Month = Integer.parseInt(nowDate.format(MonthFormat));
    int Day = Integer.parseInt(nowDate.format(DayFormat));
    String date = nowDate.format(DateFormat);

    ArrayList<Record> record = statisticsMapper.selectTypeRecord(user_id, date);
    ArrayList<Statistics> userRecord = statisticsMapper.selectAllUser(user_id);

    for (int i = 0; i < userRecord.size(); i++) {
      sumU += userRecord.get(i).getValue();
    }

    for (int i = 0; i < userRecord.size(); i++) {
      int year, month, day;
      year = Integer.parseInt(userRecord.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(userRecord.get(i).getDate().substring(5, 7));
      day = Integer.parseInt(userRecord.get(i).getDate().substring(8, 10));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month && Day == day) {
        sumD += userRecord.get(i).getValue();
      }
    }

    for (int i = 0; i < userRecord.size(); i++) {
      int year, month;
      year = Integer.parseInt(userRecord.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(userRecord.get(i).getDate().substring(5, 7));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month) {
        sumM += userRecord.get(i).getValue();
      }
    }

    model.addAttribute("st1", record);
    model.addAttribute("sumD", sumD);
    model.addAttribute("sumM", sumM);

    return "statistics.html";
  }

  @PostMapping
  public String statistics(@RequestParam String value, ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());
    int sumU = 0;
    int sumD = 0;
    int sumM = 0;

    int Year = Integer.parseInt(value.substring(0, 4));
    int Month = Integer.parseInt(value.substring(5, 7));
    int Day = Integer.parseInt(value.substring(8, 10));

    ArrayList<Record> record = statisticsMapper.selectTypeRecord(user_id, value);
    ArrayList<Statistics> userRecord = statisticsMapper.selectAllUser(user_id);

    for (int i = 0; i < userRecord.size(); i++) {
      sumU += userRecord.get(i).getValue();
    }

    for (int i = 0; i < userRecord.size(); i++) {
      int year, month, day;
      year = Integer.parseInt(userRecord.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(userRecord.get(i).getDate().substring(5, 7));
      day = Integer.parseInt(userRecord.get(i).getDate().substring(8, 10));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month && Day == day) {
        sumD += userRecord.get(i).getValue();
      }
    }

    for (int i = 0; i < userRecord.size(); i++) {
      int year, month;
      year = Integer.parseInt(userRecord.get(i).getDate().substring(0, 4));
      month = Integer.parseInt(userRecord.get(i).getDate().substring(5, 7));
      System.out.println(year);
      System.out.println(month);
      if (Year == year && Month == month) {
        sumM += userRecord.get(i).getValue();
      }
    }

    model.addAttribute("st1", record);
    model.addAttribute("sumD", sumD);
    model.addAttribute("sumM", sumM);
    return "statistics.html";
  }
}
