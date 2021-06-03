package in.nandhini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import in.nandhini.model.MessageConstants;
import in.nandhini.validation.CardValidation;

public class TestCardDetails {

	/**
	 * to check card number length whether its 16 or not
	 */
	@Test
	public void cardNumberLengthCheck() {
		String cardNo = " 8765343312345678 ";
		boolean output = false;
		output = CardValidation.cardNumberLength(cardNo);
		assertTrue(output);
	}

	/**
	 * to check invalid card number length whether its 16 or not
	 */
	@Test
	public void cardNumberLengthInvalid() {
		try {
			String cardNo = "87655678";
			CardValidation.cardNumberLength(cardNo);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(MessageConstants.INVALID_CARD_NO, e.getMessage());
		}
	}

	@Test
	public void cardNumberEmpty() {
		try {
			String cardNo = " ";
			CardValidation.cardNumberLength(cardNo);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(MessageConstants.INVALID_CARD_NO, e.getMessage());
		}
	}

	/**
	 * to check card validity year and month
	 */
	@Test
	public void cardValid() {
		String yearMonth = "2021-09";
		boolean output = false;
		output = CardValidation.creditcardValidyear(yearMonth);
		assertTrue(output);
	}

	/**
	 * to check invalid card validity year and month
	 */
	@Test
	public void cardInvalid() {
		try {
			String yearMonth = "2021-02";
			CardValidation.creditcardValidyear(yearMonth);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(MessageConstants.CARD_EXPIRED, e.getMessage());
		}
	}

	@Test
	public void validCVV() {
		String cvv = "345";
		boolean output = false;
		output = CardValidation.cvvNo(cvv);
		assertTrue(output);
	}

	@Test
	public void emptyCVV() {
		try {
			String cvv = "";
			CardValidation.cvvNo(cvv);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(MessageConstants.CVV, e.getMessage());
		}
	}

	@Test
	public void invalidCVV() {
		try {
			String cvv = "12345";
			CardValidation.cvvNo(cvv);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(MessageConstants.CVV, e.getMessage());
		}
	}

	@Test
	public void cardValidCheck() {
		String cardNo = " 8765343312345678 ";
		String cvv = "123";
		String yearMonth = "2021-07";
		boolean output = false;
		output = OnlinePayment.allCardOrientedValidityCheck(cardNo, yearMonth, cvv);
		assertTrue(output);
	}

	@Test
	public void invalidCard() {
		try {
			String cardNo = " 876534331278 ";
			String cvv = "122as3";
			String yearMonth = "2021-03";
			OnlinePayment.allCardOrientedValidityCheck(cardNo, yearMonth, cvv);
			System.out.println();
			fail();
		} catch (RuntimeException e) {
			assertEquals(MessageConstants.INVALID_CARD_NO, e.getMessage());
		}

	}
}