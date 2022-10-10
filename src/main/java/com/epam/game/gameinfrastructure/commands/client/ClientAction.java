package com.epam.game.gameinfrastructure.commands.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Igor_Petrov@epam.com
 * Created at 1/16/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAction {
    private long from;
    private long to;
    private int unitsCount;
}
