package uk.co.caeldev.spring.mvc;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public final class ETagBuilder {

    private String value;

    private ETagBuilder() {
    }

    public static ETagBuilder eTagBuilder() {
        return new ETagBuilder();
    }

    public ETagBuilder value(final String value) {
        this.value = value;
        return this;
    }

    public String build() {
        checkNotNull(value, "Seed value for ETag should not be null");
        checkArgument(!value.isEmpty(), "Seed value for ETag should not be empty");

        final HashFunction hashFunction = Hashing.md5();
        final HashCode hashCode = hashFunction.newHasher().putString(value, Charsets.UTF_8).hash();
        return Integer.toHexString(hashCode.asInt());
    }
}
