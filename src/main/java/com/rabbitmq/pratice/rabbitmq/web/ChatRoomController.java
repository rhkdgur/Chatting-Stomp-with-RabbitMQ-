package com.rabbitmq.pratice.rabbitmq.web;

import com.rabbitmq.pratice.rabbitmq.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * packageName    : com.rabbitmq.pratice.rabbitmq.web
 * fileName       : ChatRoomController
 * author         : rhkdg
 * date           : 2024-07-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-04        rhkdg       최초 생성
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    /**
     * 방 전체 조회
     * @return
     * @throws Exception
     */
    @GetMapping(value="/rooms")
    public ModelAndView rooms() throws Exception {

        ModelAndView mv = new ModelAndView("chat/rooms");

        mv.addObject("list", chatRoomService.selectChatRoomList());

        return mv;
    }

    /**
     * 방생성
     * @param name
     * @param rttr
     * @return
     * @throws Exception
     */
    @PostMapping(value="/room/create")
    public String create(@RequestParam String name, RedirectAttributes rttr) throws Exception {

        rttr.addFlashAttribute("roomName",chatRoomService.insertChatRoom(name).getName());
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public String getRoom(@RequestParam("roomId") String roomId,
                          @RequestParam("login") String login,
                          Model model) throws Exception {

        model.addAttribute("loginId", login);

        model.addAttribute("room",chatRoomService.selectChatRoom(roomId));

        model.addAttribute("list", chatRoomService.selectChatMessageList(roomId));
        return "chat/room";
    }

}
