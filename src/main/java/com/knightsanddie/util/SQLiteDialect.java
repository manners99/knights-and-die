package com.knightsanddie.util;

import java.sql.Types;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

/**
 * Minimal SQLite dialect for Hibernate 6.
 * This implements the smallest set of behaviours Hibernate needs for basic CRUD
 * and DDL generation with SQLite. It's intentionally small and suitable for a
 * learning project. For production use, consider a more complete dialect.
 */
public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
        // Register common column types
        registerColumnType(Types.BIT, "boolean");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.VARCHAR, "text");
        registerColumnType(Types.CHAR, "text");
        registerColumnType(Types.BLOB, "blob");

        // Simple SQL functions
        registerFunction("concat", new StandardSQLFunction("concat", new StringType()));
    }

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public boolean hasDataTypeInIdentityColumn() {
        // SQLite uses "INTEGER PRIMARY KEY" which implicitly becomes alias for rowid
        return false;
    }

    @Override
    public String getIdentityColumnString() {
        // return the column type used for identity
        return "integer";
    }

    @Override
    public String getIdentitySelectString() {
        return "select last_insert_rowid()";
    }

    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String query, boolean hasOffset) {
        return query + (hasOffset ? " limit ? offset ?" : " limit ?");
    }

    @Override
    public boolean supportsTemporaryTables() {
        return true;
    }

    @Override
    public boolean dropTemporaryTableAfterUse() {
        return false;
    }

    @Override
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }

    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    @Override
    public boolean hasAlterTable() {
        return false;
    }

    @Override
    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

}
