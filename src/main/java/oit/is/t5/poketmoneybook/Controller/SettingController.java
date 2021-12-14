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

import oit.is.t5.poketmoneybook.model.Kind;
import oit.is.t5.poketmoneybook.model.KindMapper;

@Controller
@RequestMapping("/Setting")
public class SettingController {
  @Autowired
  KindMapper kindMapper;

  @GetMapping
  public String log(ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());
    ArrayList<Kind> kind = kindMapper.selectAllUserkind(user_id);
    model.addAttribute("setting1", kind);
    return "record.html";
  }
}
