package app.quan_ly_dien_thoai.controller;

import app.quan_ly_dien_thoai.model.Phones;
import app.quan_ly_dien_thoai.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/smartphones")
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;

    @PostMapping
    public ResponseEntity<Phones> createSmartphone(@RequestBody Phones smartphone) {
        return new ResponseEntity<>(iPhoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Phones>> allPhones() {
        return new ResponseEntity<>(iPhoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phonelist");
        modelAndView.addObject("smartphones", iPhoneService.findAll());
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phones> deleteSmartphone(@PathVariable Integer id) {
        Optional<Phones> smartphoneOptional = iPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iPhoneService.delete(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}