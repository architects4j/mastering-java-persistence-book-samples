package dev.a4j.mastering.data.infra;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.sql.Connection;
import java.util.function.Supplier;

import static org.jooq.impl.DSL.using;

@ApplicationScoped
class ContextSupplier implements Supplier<DSLContext> {

    private final Connection connection;

    @Inject
    ContextSupplier(Connection connection) {
        this.connection = connection;
    }

    @Override
    @Produces
    public DSLContext get() {
        return using(connection, SQLDialect.H2);
    }
}
