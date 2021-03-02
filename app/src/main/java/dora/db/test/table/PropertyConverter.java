package dora.db.test.table;

public interface PropertyConverter<P, D> {

    P convertToEntityProperty(D databaseValue);

    D convertToDatabaseValue(P entityProperty);
}
