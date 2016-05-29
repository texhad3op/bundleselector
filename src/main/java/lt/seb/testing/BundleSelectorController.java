package lt.seb.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lt.seb.testing.resolver.types.Bundle;
import lt.seb.testing.services.BundleSelectorService;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = "lt.seb.testing")
public class BundleSelectorController {

    @Autowired
    BundleSelectorService bundleResolverService;

    @RequestMapping(path = "/getbundle", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Answer> getBundle(@RequestParam(value = "age", defaultValue = "-1") Integer age,
            @RequestParam(value = "isstudent", defaultValue = "false") Boolean isStudent,
            @RequestParam(value = "income", defaultValue = "-1") Integer income) {
        Answer answer = bundleResolverService.resolveBundle(age, isStudent, income);
        return new ResponseEntity<Answer>(answer, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/checkbundle", produces = "application/json")
    @ResponseBody
    public ResponseEntity<CheckAnswer> checkkBundle(@RequestParam(value = "age", defaultValue = "-1") Integer age,
            @RequestParam(value = "isstudent", defaultValue = "false") Boolean isStudent,
            @RequestParam(value = "income", defaultValue = "-1") Integer income,
            @RequestParam(value = "bundle", defaultValue = "") Bundle expectedBundle) {

        CheckAnswer checkAnswer = bundleResolverService.checkBundle(age, isStudent, income, expectedBundle);       
        return new ResponseEntity<CheckAnswer>(checkAnswer, checkAnswer.getBundleIsCorrect()?HttpStatus.OK:HttpStatus.ACCEPTED);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BundleSelectorController.class, args);
    }
}
