package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.controller.ErrorMessages;
import lotto.model.customer.Customer;
import lotto.model.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSalesServiceTest {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    private LottoSalesService lottoSalesService;

    @BeforeEach
    void setUp() {
        this.lottoSalesService = new LottoSalesService();
    }

    @Test
    @DisplayName("잘못된 단위로 구매 가격을 입력할 경우 예외를 던진다.")
    void throwExceptionWhenPaidAmountHasInvalidUnit() {
        // given
        int invalidUnitInput = PRICE_OF_LOTTO_TICKET + 1;

        // when & then
        assertThatThrownBy(() -> lottoSalesService.sellLottoToNewCustomer(invalidUnitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT);
    }

    @Test
    @DisplayName("구매한 금액의 개수만큼 로또 티켓을 가진다.")
    void generateLottoTicketsBasedOnAmountPaid() {
        // given
        int sizeOfLottoTicket = 5;
        int paidAmount = PRICE_OF_LOTTO_TICKET * sizeOfLottoTicket;

        // when
        Customer customer = lottoSalesService.sellLottoToNewCustomer(paidAmount);
        List<LottoDto> result = lottoSalesService.getIssuedLottoNumbersOf(customer);

        // then
        assertThat(result.size()).isEqualTo(sizeOfLottoTicket);
    }
}
