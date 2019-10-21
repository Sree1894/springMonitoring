package com.monitoring.springMonitoring.Controllers;

import com.monitoring.springMonitoring.Enums.ApiResponseEnums;
import com.monitoring.springMonitoring.PayLoad.ApiResponse;
import com.monitoring.springMonitoring.Utils.Examples;
import com.monitoring.springMonitoring.Utils.RunCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cmd")
public class CmdControllers {



    @GetMapping("/{command}")
    public ApiResponse getIpConfig(@PathVariable String command){
        System.out.println("command api");


        Examples.runFun();
//        RunCmd runCmd=new RunCmd();
//        runCmd.printIPInfo();

        return new ApiResponse(ApiResponseEnums.API_RESPONSE_FAILED.getCode(),
                true, ApiResponseEnums.API_RESPONSE_FAILED.getMessage(), null);
    }
}
