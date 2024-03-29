package chess.view;

import chess.controller.command.Command;
import chess.view.mapper.CommandMapper;

import java.util.Scanner;

public class InputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Scanner scanner = new Scanner(System.in);

    public Command readFirstCommand() {
        String message = String.join(LINE_SEPARATOR,
                "> 체스 게임을 시작합니다.",
                "> 게임 시작 : start",
                "> 게임 종료 : end",
                "> 게임 이동 : move source위치 target위치 - 예. move b2 b3"
        );
        System.out.println(message);

        return CommandMapper.toFirstCommand(scanner.nextLine());
    }

    public Command readFollowingCommand() {
        return CommandMapper.toFollowingCommand(scanner.nextLine());
    }
}
