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

import oit.is.t5.poketmoneybook.model.Kind;
import oit.is.t5.poketmoneybook.model.KindMapper;
import oit.is.t5.poketmoneybook.model.Type;
import oit.is.t5.poketmoneybook.model.TypeMapper;
import oit.is.t5.poketmoneybook.model.Record;
import oit.is.t5.poketmoneybook.model.RecordMapper;
import oit.is.t5.poketmoneybook.model.Journal;
import oit.is.t5.poketmoneybook.model.JournalMapper;

@Controller
@RequestMapping("/Journal")
public class JournalController {
  @Autowired
  JournalMapper journalMapper;

  @GetMapping
  public String journal(ModelMap model, Principal prin) {

    int user_id = Integer.parseInt(prin.getName());
    int sumS = 0;
    int sumI = 0;

    model.addAttribute("dateInfo", "なし");

    ArrayList<Record> record = journalMapper.selectAllRecord(user_id);

    for (int i = 0; i < record.size(); i++) {
      if (record.get(i).getStatus() == 0)
        sumS += record.get(i).getValue();
      else if (record.get(i).getStatus() == 1)
        sumI += record.get(i).getValue();
    }

    Record sumSRecord = new Record();
    sumSRecord.setType_name("支出合計");
    sumSRecord.setValue(sumS);
    sumSRecord.setKind_name("");
    sumSRecord.setDate("");
    record.add(sumSRecord);

    Record sumIRecord = new Record();
    sumIRecord.setType_name("収入合計");
    sumIRecord.setValue(sumI);
    sumIRecord.setKind_name("");
    sumIRecord.setDate("");
    record.add(sumIRecord);

    model.addAttribute("journal", record);

    return "journal.html";
  }

  @PostMapping
  public String journal(@RequestParam String dateFrom, @RequestParam String dateTo, ModelMap model, Principal prin) {
    int user_id = Integer.parseInt(prin.getName());
    int sumS = 0;
    int sumI = 0;

    model.addAttribute("dateInfo", dateFrom + "～" + dateTo);

    ArrayList<Record> record = journalMapper.selectDateRecord(user_id, dateFrom, dateTo);

    for (int i = 0; i < record.size(); i++) {
      if (record.get(i).getStatus() == 0)
        sumS += record.get(i).getValue();
      else if (record.get(i).getStatus() == 1)
        sumI += record.get(i).getValue();
    }

    Record sumSRecord = new Record();
    sumSRecord.setType_name("支出合計");
    sumSRecord.setValue(sumS);
    sumSRecord.setKind_name("");
    sumSRecord.setDate("");
    record.add(sumSRecord);

    Record sumIRecord = new Record();
    sumIRecord.setType_name("収入合計");
    sumIRecord.setValue(sumI);
    sumIRecord.setKind_name("");
    sumIRecord.setDate("");
    record.add(sumIRecord);

    model.addAttribute("journal", record);
    return "journal.html";
  }
}
