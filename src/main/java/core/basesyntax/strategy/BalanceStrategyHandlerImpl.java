package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDaoTransaction;
import core.basesyntax.model.FruitTransaction;

public class BalanceStrategyHandlerImpl implements StrategyHandler {
    private final FruitDaoTransaction fruitDao;

    public BalanceStrategyHandlerImpl(FruitDaoTransaction fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public int doStrategy(FruitTransaction fruitTransaction) {
        Integer oldQuantity = fruitDao.getFruitMap().get(fruitTransaction.getFruitName());
        Integer newQuantity = fruitTransaction.getQuantity();
        return oldQuantity + newQuantity;
    }
}
