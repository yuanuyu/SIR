package com.ruoyi.demo.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Anonymous
@Controller
@RequestMapping("/demo/school")
public class DemoController extends BaseController
{
    @Anonymous
    @GetMapping("/list")
    public TableDataInfo list()
    {
       return getDataTable(null);
    }
}
