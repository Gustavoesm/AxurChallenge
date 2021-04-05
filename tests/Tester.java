package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import challenge.*;

import static challenge.StringComparator.compareWithHomoglyphs;

public class Tester {

	@Test
	void testSiteMocky() throws IOException{
		URL url = new URL("http://www.mocky.io/v2/5e18df272f00007e0097e1b4");
		SafetyCheck checker = SafetyCheck.create(url, SuspiciousWordTest.getInstance());
		assertEquals(true, checker.isSuspicious());
	}

	@Test
	void testSiteNestle() throws IOException {
		URL url = new URL("https://www.nestle.com.br/promocoes");
		SafetyCheck checker = SafetyCheck.create(url, SuspiciousWordTest.getInstance());
		assertEquals(true, checker.isSuspicious());
	}
	
	@Test
	void testSiteBlackFriday() throws IOException {
		URL url = new URL("https://www.blackfriday.com.br/");
		SafetyCheck checker = SafetyCheck.create(url, SuspiciousWordTest.getInstance());
		assertEquals(true, checker.isSuspicious());
	}
	
	@Test
	void testSiteGoogle() throws IOException {
		URL url = new URL("https://www.google.com/");
		SafetyCheck checker = SafetyCheck.create(url, SuspiciousWordTest.getInstance());
		assertEquals(false, checker.isSuspicious());
	}

	@Test
	public void testBrokenURLException() {
		assertThrows(MalformedURLException.class, () -> {
			URL url = new URL("thishouldnotwork");
			SafetyCheck.create(url, SuspiciousWordTest.getInstance());
		});
	}

	@Test
	void testCompare() {
		final String BANANA = "banana";
		assertEquals(true, compareWithHomoglyphs("banana", BANANA));
		assertEquals(true, compareWithHomoglyphs("Banana", BANANA));
		assertEquals(true, compareWithHomoglyphs("BANANA", BANANA));
		assertEquals(true, compareWithHomoglyphs("a e i o u", "A E I O U"));
		assertEquals(false, compareWithHomoglyphs("black driday", "black friday"));
		assertEquals(false, compareWithHomoglyphs("Whindersson", "Winderson"));
		assertEquals(true, compareWithHomoglyphs("maçã", "maca"));
		assertEquals(true, compareWithHomoglyphs("$3N#4", "senha"));
		assertEquals(true, compareWithHomoglyphs("Promoção", "promocao"));
	}
}
