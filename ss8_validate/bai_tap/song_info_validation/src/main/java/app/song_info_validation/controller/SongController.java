package app.song_info_validation.controller;

import app.song_info_validation.dto.SongDto;
import app.song_info_validation.model.Song;
import app.song_info_validation.reponsitory.ISongReponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongReponsitory iSongReponsitory;

    @GetMapping({"", "song"})
    public String showHomePage(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("songList", iSongReponsitory.findAll());
        redirectAttributes.addFlashAttribute("mess", "");
        return "home";
    }

    @GetMapping("addNew")
    public ModelAndView showCreatePage() {
        return new ModelAndView("createpage", "newSong", new SongDto());
    }

    @PostMapping("saveSong")

    public String saveSong(@Validated @ModelAttribute("newSong") SongDto songDto,
                           BindingResult bs,
                           RedirectAttributes ra,
                           Model model) {
        new SongDto().validate(songDto,bs);
        if (bs.hasFieldErrors()) {
            return "createpage";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            iSongReponsitory.save(song);
            ra.addFlashAttribute("mess", "add new song success");
            return "redirect:/song";

        }
    }

    @GetMapping("/updateSong/{id}")
    public ModelAndView showUpdatePage(@PathVariable Integer id){
        Song song = iSongReponsitory.findById(id).get();
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        return new ModelAndView("updatepage","updateSong",songDto);
    }

    @PostMapping("/saveUpdateSong")
    public String saveUpdate(@Validated @ModelAttribute SongDto updateSong,
                           BindingResult bs,
                           RedirectAttributes ra) {
        new SongDto().validate(updateSong,bs);
        if (bs.hasFieldErrors()) {
            return "updatepage";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(updateSong, song);
            iSongReponsitory.save(song);
            ra.addFlashAttribute("mess", "update song success");
            return "redirect:/song";

        }
    }


}
