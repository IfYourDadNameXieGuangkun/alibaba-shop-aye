package com.lppz.stock.web;

import com.aye.commons.dto.CR;
import com.aye.commons.dto.ResultDTO;
import com.lppz.stock.platform.base.BaseController;
import com.lppz.stock.platform.base.BaseResponse;
import com.lppz.stock.platform.base.SynProvider;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class Api extends BaseController {

    @PostMapping("/com/lppz/stock/{channel}")
    public CR<?> stock(@PathVariable("channel") String channel
//            , @Validated @RequestBody StockEntry stock
    ) {
//        System.out.println(JSONObject.toJSONString(stock));
        SynProvider synHandler = this.getSynHandler(channel);
        BaseResponse run = synHandler.run("123");
        return ResultDTO.create();
    }


}
