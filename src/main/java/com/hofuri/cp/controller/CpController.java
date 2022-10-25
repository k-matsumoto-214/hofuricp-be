package com.hofuri.cp.controller;

import com.hofuri.cp.model.statistic.daily.CpDailyAmountList;
import com.hofuri.cp.presentation.request.CpAmountRequest;
import com.hofuri.cp.presentation.response.CpDailyAmountResponse;
import com.hofuri.cp.service.CpFindService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CpController {

  private final CpFindService cpFindService;

  /**
   * 指定した期間の各発行体の日次残高を取得する
   *
   * @param request 日次残高取得リクエスト
   * @return 指定した期間の各発行体の日次残高レスポンス
   */
  @GetMapping("cp/amount")
  public CpDailyAmountResponse findCpAmountBetweenDate(@Valid CpAmountRequest request) {

    CpDailyAmountList cpDailyAmountList =
        cpFindService.findCpAmountBetweenDate(request.getFrom(), request.getTo());

    return CpDailyAmountResponse.from(cpDailyAmountList.getCpDailyAmounts());
  }
}
