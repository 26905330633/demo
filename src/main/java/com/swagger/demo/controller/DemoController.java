package com.swagger.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "Demo测试管理",tags = "Demo测试管理")
public class DemoController {

    @ApiOperation(value = "获取Demo信息", notes = "获取Demo信息", tags = "获取Demo信息")
    @GetMapping(value="/getDemoInfo")
    public String getDemoInfo(@ApiParam(value = "demoId" , required=true ) @RequestParam String demoId) {
        return demoId + "是Demo测试信息";
    }

    @ApiOperation(value = "添加Demo信息", notes = "添加Demo信息",tags = "添加Demo信息")
    @PostMapping(value="/addDemoInfo")
    public String addDemoInfo(@RequestBody String name) {
        return "添加成功，Demo信息：" + name;
    }

    @ApiOperation(value = "修改Demo信息", notes = "修改Demo信息",tags = "修改Demo信息")
    @PutMapping(value="/updateDemoInfo")
    public String updateDemoInfo(@RequestParam String name, @RequestParam Integer age, @RequestParam String gender) {
        return "修改Demo信息修改成功，Demo信息——>姓名：" + name + "--年龄：" + age + "--性别：" + gender;
    }

    @ApiOperation(value = "删除Demo信息", notes = "根据demo编号删除Demo信息",tags = "删除Demo信息")
    @DeleteMapping(value="/deleteDemoInfo")
    public String deleteDemoInfo(@RequestParam String demoId) {
        return "删除成功！删除的Demo编号为 ：" + demoId;
    }

    @ApiOperation(value = "测试远程接口调用", notes = "测试远程接口调用",tags = "测试远程接口调用")
    @PostMapping(value="/testInvokeApi")
    public Map<String, Object> testInvokeApi(@RequestBody Map<String, Object> reqMap) {
        System.out.println(reqMap);
        Map<String, Object> respMap = new HashMap<>();
        //
        respMap.put("processCode", "0000");
        respMap.put("processInfo", "接口调用成功");
        respMap.put("result", reqMap);
        return respMap;
    }


}
