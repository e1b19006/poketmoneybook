package oit.is.t5.poketmoneybook.Controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.t5.poketmoneybook.model.Record;
import oit.is.t5.poketmoneybook.model.RecordMapper;

@Controller
@RequestMapping("/Record")
public class RecordController {
  @Autowired
  RecordMapper recordMapper;

  @GetMapping("log")
  public String log(ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());
    ArrayList<Record> record = recordMapper.selectAllRecord(user_id);
    model.addAttribute("log1", record);
    return "record.html";
  }

  /**
   *
   *
   * @param model
   * @return
   */

  @PostMapping("/insert")
  @Transactional
  public String insert(@RequestParam Integer value, @RequestParam Integer kind_id, @RequestParam Integer type_id,
      ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());
    Record record2 = new Record();
    record2.setValue(value);
    record2.setUser_id(user_id);
    record2.setKind_id(kind_id);
    record2.setType_id(type_id);
    record2.setDate("2010-05-11");
    record2.setTime("00:00:00");
    recordMapper.insertLog(record2);
    model.addAttribute("record2", record2);
    return "record.html";
  }

}
