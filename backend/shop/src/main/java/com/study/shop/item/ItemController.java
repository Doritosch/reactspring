package com.study.shop.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Item> result = itemService.findAllItem();
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    public String write() {
        return "write.html";
    }

    @PostMapping("/item")
    public String addItem(@RequestParam String title,
                          @RequestParam int price, Authentication auth) {
        itemService.saveItem(title, price, auth.getName());
        return "list.html";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Item result = itemService.findEachItem(id);
        model.addAttribute("data", result);
        return "detail.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Item result = itemService.findEachItem(id);
        model.addAttribute("item", result);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @RequestParam String title, @RequestParam Integer price) {
       itemService.patchItem(id, title, price);
       return "redirect:/list";
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        Item item = itemService.deleteItem(id);
        return ResponseEntity.status(200).body("delete complete");
    }

}
