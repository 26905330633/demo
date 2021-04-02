package com.swagger.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "这是testController管理",tags = "这是testController管理")
public class TestController {

    @ApiOperation(value = "获取Test信息", notes = "获取Test信息", tags = "获取Test信息")
    @GetMapping(value="/getTestInfo")
    public String getTestInfo(@ApiParam(value = "demoId" , required=true ) @RequestParam String demoId) {
        return demoId + "是Test测试信息";
    }

    @ApiOperation(value = "添加Test信息", notes = "添加Test信息",tags = "添加Test信息")
    @PostMapping(value="/addTestInfo")
    public String addTestInfo(@RequestBody String name) {
        return "添加成功，Test信息：" + name;
    }

    @ApiOperation(value = "修改Test信息", notes = "修改Test信息",tags = "修改Test信息")
    @PutMapping(value="/updateTestInfo")
    public String updateTestInfo(@RequestParam String name, @RequestParam Integer age, @RequestParam String gender) {
        return "修改Test信息修改成功，Test信息——>姓名：" + name + "--年龄：" + age + "--性别：" + gender;
    }

    @ApiOperation(value = "删除Test信息", notes = "根据demo编号删除Test信息",tags = "删除Test信息")
    @DeleteMapping(value="/deleteTestInfo")
    public String deleteTestInfo(@RequestParam String demoId) {
        return "删除成功！删除的Test编号为 ：" + demoId;
    }
}
