package monkeys;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * (C) Copyright 6/20/13 Hewlett-Packard Development Company, L.P.
 * Date: 6/20/13
 * Time: 10:22 AM
 *
 * @author abdiel
 */
@Controller
public class MonkeysController {

    @RequestMapping(method = RequestMethod.POST, value = "/monkeys", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createJob() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(method = RequestMethod.GET, value="/monkeys", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Monkey>> getAllMonkeys() {
        List<Monkey> list = new ArrayList<>();
        list.add(new Monkey("narf"));
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<List<Monkey>>(list, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/monkeys/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Monkey> getJob(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Monkey>(new Monkey(id), headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/monkeys/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.NOT_IMPLEMENTED);
    }
}