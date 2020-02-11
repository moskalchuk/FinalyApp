package springApp;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springApp.Domain.Messages;
import springApp.Repos.MessageRepo;

import javax.sql.DataSource;
import java.util.Map;


@Controller
    public class GreetingController {
        @Autowired
        private MessageRepo messageRepo;

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
            model.put("name", name);
            return "greeting";
        }

        @GetMapping
        public String main(Map<String, Object> model){
           Iterable<Messages> messages= messageRepo.findAll();
            model.put("messages", messages);
            return "main";
        }
        @PostMapping
        public String add(@RequestParam String text,@RequestParam String tag, Map<String,Object> model){
           Messages message= new Messages(text,tag);

           messageRepo.save(message);
            Iterable<Messages> messages= messageRepo.findAll();
            model.put("messages", messages);

            return "main";
        }

    }
