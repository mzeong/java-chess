package chess.view.mapper;

import chess.controller.command.Command;
import chess.controller.command.End;
import chess.controller.command.Move;
import chess.controller.command.Start;
import chess.domain.position.Position;
import java.util.Set;
import java.util.function.Function;

public enum CommandMapper {

    START(input -> input.equals("start"), input -> new Start()),
    END(input -> input.equals("end"), input -> new End()),
    MOVE(CommandMapper::isMove, CommandMapper::toMove),
    ;

    private final Function<String, Boolean> isCommand;
    private final Function<String, Command> toCommand;

    CommandMapper(Function<String, Boolean> isCommand, Function<String, Command> toCommand) {
        this.isCommand = isCommand;
        this.toCommand = toCommand;
    }

    private static boolean isMove(String input) {
        String[] split = input.split(" ");
        return split.length == 3 && split[0].equals("move");
    }

    private static Command toMove(String input) {
        String[] split = input.split(" ");
        Position source = toPosition(split[1]);
        Position target = toPosition(split[2]);
        return new Move(source, target);
    }

    private static Position toPosition(String string) {
        String file = string.substring(0, 1);
        String rank = string.substring(1);
        return new Position(FileMapper.from(file), RankMapper.from(rank));
    }

    public static Command toFirstCommand(String input) {
        return toCommand(Set.of(START, END), input);
    }

    public static Command toFollowingCommand(String input) {
        return toCommand(Set.of(MOVE, END), input);
    }

    private static Command toCommand(Set<CommandMapper> commands, String input) {
        return commands.stream()
                .filter(it -> it.isCommand.apply(input))
                .findAny()
                .map(it -> it.toCommand.apply(input))
                .orElseThrow(() -> new IllegalArgumentException("사용할 수 없는 명령어입니다."));
    }
}
