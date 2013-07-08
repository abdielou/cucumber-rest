package monkeys.web;

import monkeys.Banana;
import monkeys.BananaRepository;
import monkeys.Monkey;
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
@RequestMapping(value = "/bananas")
public class BananasController {
    @Autowired
    private BananaRepository bananaRepository;

    @RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> createBanana(@RequestBody Banana banana) {
        bananaRepository.save(banana);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Banana>> getAllBananas() {
        List<Banana> monkeyList = (List<Banana>) bananaRepository.findAll();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(monkeyList, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Banana> getBanana(@PathVariable Long id) {
        Banana banana = bananaRepository.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(banana, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteBanana(@PathVariable Long id) {
        bananaRepository.delete(id);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
