package com.he20o.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.he20o.domain.air.Airport;
import com.he20o.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*") // 상단 url - guest상위 폴더로 진입시 여기로 진입하게 됨.
@AllArgsConstructor // 필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌.
					// 같은 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌 (@Auto와 비슷)
@Controller
public class GuestController {
	private GuestService service;

	@GetMapping("/getList") // 하단 url(함수별) -/guest/getList url 진입 시
	public void getList(Model model) { // 매개변수에 Model m식으로 적성하면
										// 스프링이 알아서 모델 객체를 만들어서 넘겨줌.
		model.addAttribute("list", service.getList());
		// 위 /getList와 동일한 jsp파일(/guest/guestList.jsp)을 엶.
	}

	@GetMapping("/read")
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		model.addAttribute("read", service.read(bno));

	}

	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ===============" + bno);
		service.del(bno);
		return "redirect:/guest/getList";
	}

	/*
	 * // 공공api_기상청// private static final String API_KEY =
	 * "mK3NAc7s5GyqFtcDP0kpm%2FAudnmuGu%2B5tr0nNP%2Ba0Jgw0GBmfFvgJ548FgFgWw7jh1SrswcV03pX3J6PuyzZVQ%3D%3D";
	 * private static final String API_URL =
	 * "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20230220&endDt=20230220&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey="
	 * + API_KEY;
	 * 
	 * @GetMapping("/kw") public void kw() { RestTemplate restTemplate = new
	 * RestTemplate();
	 * 
	 * //// **** 중요 **** uri URI uri = null; // java.net.URI 임포트 하셈 try { uri = new
	 * URI(API_URL); } catch (URISyntaxException e) { e.printStackTrace(); }
	 * 
	 * String s = restTemplate.getForObject(uri, String.class); //
	 * log.info("====== 우리나라 날씨 잘 나오나? " + s); KWeatherVO kw =
	 * restTemplate.getForObject(uri, KWeatherVO.class);
	 * log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : " + kw.response.body.dataType);
	 * log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : " + kw.response.body.dataType);
	 * String location = kw.response.body.items.item.get(0).stnNm; String tMin =
	 * kw.response.body.items.item.get(0).minTa; String tMax =
	 * kw.response.body.items.item.get(0).maxTa; String ddara = String.
	 * format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다."
	 * , location, tMin, tMax); log.info(ddara); }
	 */

	// 공공api_공항혼잡도//
	private static final String API_AIRKEY = "mK3NAc7s5GyqFtcDP0kpm%2FAudnmuGu%2B5tr0nNP%2Ba0Jgw0GBmfFvgJ548FgFgWw7jh1SrswcV03pX3J6PuyzZVQ%3D%3D";
	private static final String API_AIRURL = "https://apis.data.go.kr/B551177/StatusOfArrivals/getArrivalsCongestion?&numOfRows=10&pageNo=1&type=json&serviceKey="
			+ API_AIRKEY;

	@GetMapping("/airport")
	public void air() {
		RestTemplate restTemplate = new RestTemplate();

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_AIRURL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String s = restTemplate.getForObject(uri, String.class);
		log.info("====== 공항에 사람이 얼마나 많은가?" + s);

		Airport air = restTemplate.getForObject(uri, Airport.class);
		String terminal = air.response.body.items.get(0).terno; // 여객터미널 정보
		String gate = air.response.body.items.get(0).entrygate; // 입국 게이트
		String nationk = air.response.body.items.get(0).korean; // 내국인 수
		String nationf = air.response.body.items.get(0).foreigner; // 외국인 수
		String schedule = air.response.body.items.get(0).scheduletime; // 기존 예정시간
		String estimate = air.response.body.items.get(0).estimatedtime; // 실시간 예정시간
		String airport = air.response.body.items.get(0).airport; // 도착지
		String gateno = air.response.body.items.get(0).gatenumber; // 게이트 번호
		String flight = air.response.body.items.get(0).flightid; // 항공편
		String airr = String.format(
				"==== json ==== : 실시간 입국장 현황 정보입니다~ 터미널 %s , 입국게이트 %s 에 내국인은 %s 명 외국인은 %s 명입니다. %s로 가는 %s 항공편 안내입니다. 예정시간은 %s 였으나 현재 %s 로 변경되었습니다. 제시간에 게이트 %s에서 대기 바랍니다.",
				terminal, gate, nationk, nationf, airport, flight, schedule, estimate, gateno);
		log.info(airr);
	}

}
