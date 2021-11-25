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
  public String log(ModelMap model) {
    ArrayList<Record> record = recordMapper.selectAllRecord();
    model.addAttribute("log1", record);
    return "record.html";
  }

}
