package com.offcn;

import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<User> list = new ArrayList<>();
    //添加
    @PostMapping("/")
    @ApiOperation(value="新增用户", notes="新增用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息实体user", required = true, dataType = "com.offcn.pojo.User")
    public  List<User> add(@RequestBody User user){
        list.add(user);
        return  list;
    }
    //查询所有
    @GetMapping("/")
    @ApiOperation(value="获取全部用户信息", notes="获取全部用户列表信息")
    public  List<User> findAll(){

        return  list;
    }
    //通过主键id查询
    @GetMapping("/{id}")
    @ApiOperation(value="获取指定id用户信息", notes="根据id获取单个用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public  User findOne(@PathVariable("id") Integer id){
        for (User user : list) {
            if (user.getId() ==id.intValue()){
                return user;
            }
        }
        return  null;
    }
    //修改
    @PutMapping ("/")
    public  List<User> update(@RequestBody User user){
        for (User temp : list) {
            if (temp.getId() ==user.getId()){
                temp.setId(user.getId());
                temp.setAge(user.getAge());
                temp.setName(user.getName());
            }

        }
        return  list;
    }
    //删除
    @DeleteMapping("/{id}")
    @ApiOperation(value="删除指定id用户", notes="根据id删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public  List<User> delete(@PathVariable("id") Integer id){
        List<User> newList = new ArrayList<>();
        for (User user : list) {
            if (user.getId()!=id.intValue()){
                newList.add(user);
            }
        }
        return  newList;
    }




}
