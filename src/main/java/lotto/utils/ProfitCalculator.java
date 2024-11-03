package lotto.utils;

import java.util.List;
import lotto.model.lotto.LottoTicket;

public class ProfitCalculator {
    public static double calculateProfitRate(List<LottoTicket> lottoTickets, int paidAmount) {
        return ((double) (calculateTotalProfit(lottoTickets)) / paidAmount) * 100;
    }

    private static int calculateTotalProfit(List<LottoTicket> lottoTickets) {
        int totalProfit = 0;

        for (LottoTicket lottoTicket : lottoTickets) {
            totalProfit += lottoTicket.getProfit();
        }

        return totalProfit;
    }
}