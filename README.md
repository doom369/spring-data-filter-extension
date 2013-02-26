spring-data-filter-extension

This project is to extend basic spring data functionality.
Mostly to allow filtering with paging on JPA entities. That basic spring date doesn't allow
============================

TODO:

1. Make SimpleFilterRepository to allow simple filter by complex relation, for instance

findAll(String field, Object value); //where field "user.roles.permissions"

2. Make FilterPagingRepository same as above but with paging, for instance

findAll(String field, Object value, Paging p);
findAll(Specification spec, Paging p);

3. Resolve all 'TODO's in code;
4. Make sorting by multiple fields;
5. Probably make type-safe version
