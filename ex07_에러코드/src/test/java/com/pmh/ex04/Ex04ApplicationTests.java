package com.pmh.ex04;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

// 스프링컨테이너 ... 올라오기 때문에
//@SpringBootTest
class Ex04ApplicationTests {

	@BeforeAll
    static void beforeAll(){
		System.out.println("테스트 메서드 실행하기 전에 한번만 발생");
	}

	@AfterAll
	static void AfterAll(){
		System.out.println("테스트 메서드 실행하기 후에 한번만 발생");
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("각 테스트 메서드 실행하기 전에 발생");
	}

	@AfterEach
	void afterEach(){
		System.out.println("각 테스트 메서드 실행하기 후에 발생");
	}

	@DisplayName("간단한 산술연산")
	@Test
	void name() {
		int a = 10;
		int b = 20;
		int sum = 30;

//		Assertions.assertEquals(sum,a+b);
	}

	@DisplayName("다른 Assertions로 산술연산 테스트")
	@Test
	void basicTest() {
		int a = 10;
		int b = 20;
		int sum = 30;

		Assertions.assertThat(a+b).isEqualTo(sum);
//		Assertions.assertThat(a).isEqualTo(b);
	}

	@DisplayName("리스트 data 테스트")
	@Test
	void listTest(){
		//given
		List<String> list = Arrays.asList("John","Jane","Jack");

		//when list 테스트...

		//then 검증
		Assertions.assertThat(list)
				.hasSize(3)
				.contains("John")
				.doesNotContain("JOE");
	}

	@Test
	void testException() {
		//given
		Throwable throwable = Assertions.catchThrowable(()->{
			throw new IllegalArgumentException("Invalid Args");
		});

		Assertions.assertThat(throwable)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("Invalid");
	}
}
