package lotto.view;

import java.util.Map;
import lotto.domain.WinningRank;

public class OutputView {
    public static final String NEWLINE_DELIMITER = "\n";
    public static final String PRINT_LOTTO_NUMBERS_FORMAT = "[%s]";
    public static final String PRINT_LOTTO_NUMBERS_DELIMITER = ", ";
    public static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String PRINT_STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PRINT_FORMAT_RATIO = "총 수익률은 %.2f입니다.";
    public static final String OUTPUT_ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String OUTPUT_MESSAGE_WINNING_STATISTICS = "당첨 통계";
    public static final String OUTPUT_MESSAGE_HYPHEN = "---------";
    public static final String ERROR_MESSAGE_MINIMUM_PURCHASE_AMOUNT = "최소 구매 금액은 1000원 입니다.";
    public static final String ERROR_MESSAGE_AMOUNT_UNIT_OF_1000 = "1000 단위로 입력해주세요.";
    public static final String ERROR_MESSAGE_INPUT_AMOUNT_ONLY_NUMBER = "숫자를 입력해주세요.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBERS_SIZE_IS_6 = "로또 번호는 6개 입니다.";

    private OutputView() {
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void error(String message) {
        System.out.println(OUTPUT_ERROR_MESSAGE_PREFIX + message);
    }

    public static void printStatistics(Map<WinningRank, Long> statisticsMap) {
        System.out.println();
        System.out.println(OUTPUT_MESSAGE_WINNING_STATISTICS);
        System.out.println(OUTPUT_MESSAGE_HYPHEN);
        statisticsMap.forEach((winningRank, winningCount) -> {
            if (winningRank.isDisplay()) {
                System.out.println(String.format(PRINT_STATISTICS_FORMAT,
                                        winningRank.getMatchCount(),
                                        winningRank.getWinningMoney(),
                                        winningCount));
            }
        });
    }

    public static void printEarningRatio(double earningRatio) {
        System.out.printf(PRINT_FORMAT_RATIO, earningRatio);
    }
}