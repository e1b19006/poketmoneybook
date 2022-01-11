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
    DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String java8Disp = nowDate.format(java8Format);
    System.out.println(java8Disp);
    int user_id = Integer.parseInt(prin.getName());
    System.out.println(user_id + " " + java8Disp);
    ArrayList<Record> record = statisticsMapper.selectTypeRecord(user_id, java8Disp);
    model.addAttribute("st1", record);
    Statistics statistics = statisticsMapper.selectSumRecord(user_id, java8Disp);
    System.out.println(statistics.getValue());
    model.addAttribute("st2", statistics);
    return "statistics.html";
  }

  @PostMapping
  public String statistics(@RequestParam String value, ModelMap model, Principal prin) {
    String java8Disp = value;
    System.out.println(java8Disp);
    int user_id = Integer.parseInt(prin.getName());
    System.out.println(user_id + " " + java8Disp);
    ArrayList<Record> record = statisticsMapper.selectTypeRecord(user_id, java8Disp);
    model.addAttribute("st1", record);
    Statistics statistics = statisticsMapper.selectSumRecord(user_id, java8Disp);
    model.addAttribute("st2", statistics);
    return "statistics.html";
  }
}
