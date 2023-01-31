package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = {"/owners/index.html","/owners"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/list";
    }
    @RequestMapping("/owners/find")
    public String findOwners(Model model){
        //model.addAttribute("find",ownerService.)
                return "owners/findOwner";
    }
}
