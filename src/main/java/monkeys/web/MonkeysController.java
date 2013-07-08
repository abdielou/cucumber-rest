package monkeys.web;

import monkeys.Monkey;
import monkeys.MonkeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MIT License
 *
 * @author abdiel
 */
@Controller
@RequestMapping(value = "/monkeys")
public class MonkeysController {
    @Autowired
    private MonkeyRepository monkeyRepository;

    @RequestMapping(method = RequestMethod.POST, value = "", consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> createMonkey(@RequestBody Monkey monkey) {
        monkeyRepository.save(monkey);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Monkey>> getAllMonkeys() {
        List<Monkey> monkeyList = (List<Monkey>) monkeyRepository.findAll();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(monkeyList, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Monkey> getMonkey(@PathVariable Long id) {
        Monkey monkey = monkeyRepository.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(monkey, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteMonkey(@PathVariable Long id) {
        monkeyRepository.delete(id);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
