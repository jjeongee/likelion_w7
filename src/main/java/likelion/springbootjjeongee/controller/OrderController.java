package likelion.springbootjjeongee.controller;

import likelion.springbootjjeongee.domain.Item;
import likelion.springbootjjeongee.domain.Member;
import likelion.springbootjjeongee.domain.Order;
import likelion.springbootjjeongee.service.ItemService;
import likelion.springbootjjeongee.service.MemberService;
import likelion.springbootjjeongee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("order")
    public String createForm(Model model){
        List<Member> members = memberService.findAll();
        List<Item> items= itemService.findAll();
        model.addAttribute("members",members);
        model.addAttribute("items",items);
        return "order/orderForm";
    }

    @PostMapping("order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count){
        orderService.createOrder(memberId,itemId,count);
        return "redirect:/orders";
    }

    @GetMapping("")
    public String orderList(Model model){
        List<Order> orderList=orderService.findOrderList();
        model.addAttribute("orders",orderList);
        return "order/orderList";
    }

    @PostMapping("{orderId}/cancle")
    public String cancelOrder(@PathVariable("orderId")Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }

}
