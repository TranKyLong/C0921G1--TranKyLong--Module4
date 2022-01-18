package app.controller;

import app.model.Song;
import app.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    ISongService iSongService;

    @GetMapping({"", "song"})
    public String showHomePage(Model model, RedirectAttributes ra) {
        model.addAttribute("list", iSongService.showALL());
        ra.addFlashAttribute("messenger", "");
        return "home";
    }

    @GetMapping("delete/{id}")
    public String showEdit(@PathVariable Long id, RedirectAttributes ra) {
        iSongService.delete(id);
        ra.addFlashAttribute("messenger", "Delete success");
        return "redirect:/song";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        Song newSong = new Song();
        model.addAttribute("mysong", newSong);
        return "/createform";
    }

    @PostMapping("save")
    public String save(Song mySong, RedirectAttributes ra) {
        iSongService.save(mySong);
        ra.addFlashAttribute("messenger", "Add new song successfuly");
        return "redirect:/song";
    }

    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("updateSong", iSongService.findById(id));
        return "update";
    }

    @PostMapping("/saveupdate")
    public String saveUpdate (Song mySong, RedirectAttributes ra){
        iSongService.save(mySong);
        ra.addFlashAttribute("messenger", "Update song successfuly");
        return "redirect:/song";
    }
}
