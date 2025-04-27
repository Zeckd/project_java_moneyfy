package kg.nurs.expensetracker.mappers;

import kg.nurs.expensetracker.models.Transaction;
import kg.nurs.expensetracker.models.dto.TransactionCreateDto;
import kg.nurs.expensetracker.models.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "transactionCreateDto.userId", target = "user.id")
    @Mapping(source = "transactionCreateDto.categoryId", target = "category.id")
    Transaction transactionCreateDtoToTransaction (TransactionCreateDto transactionCreateDto);

    @Mapping(source = "transaction.category", target = "categoryDto")
    @Mapping(source = "transaction.user.id", target = "userId")
    TransactionDto transactionToTransactionDto (Transaction transaction);
    Transaction transactionDtoToTransaction (TransactionDto transactionDto);

}
