package oit.is.t5.poketmoneybook.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.springframework.beans.factory.annotation.Autowired;
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

import oit.is.t5.poketmoneybook.model.Record;
import oit.is.t5.poketmoneybook.model.RecordMapper;
import oit.is.t5.poketmoneybook.model.Kind;
import oit.is.t5.poketmoneybook.model.KindMapper;
import oit.is.t5.poketmoneybook.model.Type;
import oit.is.t5.poketmoneybook.model.TypeMapper;

@Controller
@RequestMapping("/Record")
public class RecordController {
  @Autowired
  RecordMapper recordMapper;
  @Autowired
  KindMapper kindMapper;
  @Autowired
  TypeMapper typeMapper;

  @GetMapping("log")
  public String log(ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());
    ArrayList<Record> recordTable = recordMapper.selectAllRecord(user_id);
    for (int i = 0; i < recordTable.size(); i++) {
      Record recordTmp = new Record();
      recordTmp = recordTable.get(i);
      recordTmp.setStatusS("収入");
      recordTable.set(i, recordTmp);
    }
    model.addAttribute("log1", recordTable);
    ArrayList<Kind> kind = kindMapper.selectAllUserkind(user_id);
    ArrayList<Type> type = typeMapper.selectAllUsertype(user_id);
    model.addAttribute("setting1", kind);
    model.addAttribute("setting2", type);

    return "record.html";
  }

  /**
   *
   *
   * @param model
   * @return
   */

  /*
   * @PostMapping("/insert")
   *
   * @Transactional public String insert(@RequestParam Integer
   * value, @RequestParam Integer kind_id, @RequestParam Integer type_id,
   *
   * @RequestParam String remark, @RequestParam String date, @RequestParam String
   * time, @RequestParam String radio, ModelMap model, Principal prin) { int
   * user_id = Integer.parseInt(prin.getName()); Record record2 = new Record();
   * record2.setValue(value); record2.setUser_id(user_id);
   * record2.setKind_id(kind_id); record2.setType_id(type_id);
   * record2.setDate(date); record2.setTime(time); record2.setRemark(remark);
   * recordMapper.insertLog(record2); // model.addAttribute("record2", record2);
   * ArrayList<Record> record = recordMapper.selectAllRecord(user_id);
   * model.addAttribute("log1", record); ArrayList<Kind> kind =
   * kindMapper.selectAllUserkind(user_id); ArrayList<Type> type =
   * typeMapper.selectAllUsertype(user_id); model.addAttribute("setting1", kind);
   * model.addAttribute("setting2", type);
   *
   * return "record.html"; }
   */

  /**
   *
   * @param value
   * @param kind_id
   * @param type_id
   * @param remark
   * @param date
   * @param time
   * @param radio
   * @param to
   * @param model
   * @return
   */
  @PostMapping("/insert")
  @Transactional
  public String insert(@RequestParam Integer value, @RequestParam Integer kind_id, @RequestParam Integer type_id,
      @RequestParam String remark, @RequestParam String date, @RequestParam String time, @RequestParam String radio,
      @RequestParam Integer to, ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());

    Record record = new Record();

    /** Prosess of insert */
    record.setValue(value);
    record.setUser_id(user_id);
    record.setKind_id(kind_id);
    record.setType_id(type_id);
    record.setDate(date);
    record.setTime(time);
    record.setRemark(remark);

    switch (radio) {
      case "spending": {
        record.setStatus(0);
        break;
      }
      case "income": {
        record.setStatus(1);
        break;
      }
      case "transfer":
        record.setStatus(2);

        Record recordTo = new Record();
        recordTo.setValue(value);
        recordTo.setUser_id(user_id);
        recordTo.setKind_id(to);
        recordTo.setType_id(1);
        recordTo.setDate(date);
        recordTo.setTime(time);
        recordTo.setStatus(3);
        recordMapper.insertLog(recordTo);
        break;
    }

    recordMapper.insertLog(record);

    /** Read and add to TH for table */
    ArrayList<Record> recordTable = recordMapper.selectAllRecord(user_id);
    for (int i = 0; i < recordTable.size(); i++) {
      Record recordTmp = new Record();
      recordTmp = recordTable.get(i);
      switch (recordTmp.getStatus()) {
        case 0: {
          recordTmp.setStatusS("支出");
          break;
        }
        case 1: {
          recordTmp.setStatusS("収入");
          break;
        }
        default: {
          recordTmp.setStatusS("振替");
          break;
        }
      }
      recordTable.set(i, recordTmp);
    }
    model.addAttribute("log1", recordTable);
    ArrayList<Kind> kind = kindMapper.selectAllUserkind(user_id);
    ArrayList<Type> type = typeMapper.selectAllUsertype(user_id);
    model.addAttribute("setting1", kind);
    model.addAttribute("setting2", type);

    return "record.html";
  }

}
