package kg.nurs.expensetracker.mappers;

import kg.nurs.expensetracker.models.Transaction;
import kg.nurs.expensetracker.models.dto.BalanceUserDto;
import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;
import kg.nurs.expensetracker.models.dto.TransactionUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "categoryId", target = "category.id")
    Transaction transactionCreateDtoToTransaction (TransactionCreateDto transactionCreateDto);

    @Mapping(source = "category", target = "categoryDto")
    @Mapping(source = "user.id", target = "userId")
    TransactionDto transactionToTransactionDto (Transaction transaction);
    Transaction transactionDtoToTransaction (TransactionDto transactionDto);

    List<TransactionDto> transactionToTransactionDtoList (List<Transaction> transactions);

    Transaction transactionUpdateDtoToTransaction (TransactionUpdateDto transactionUpdateDto);

    List <BalanceUserDto> transactionToBalanceUserDtoList (List<Transaction> transactions);
}
