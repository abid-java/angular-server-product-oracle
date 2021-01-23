-- FUNCTION: public.updateproduct_location(json, bigint)

-- DROP FUNCTION public.updateproduct_location(json, bigint);

CREATE OR REPLACE FUNCTION public.updateproduct_location(
	v_product_location json,
	v_product_id bigint)
    RETURNS character varying
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
begin

update product_locations set
	address_line_1 = v_product_location ->> 'addressLine1',
	address_line_2 = v_product_location ->> 'addressLine2',
	city = v_product_location ->> 'city',
	state = v_product_location ->> 'state',
	country = v_product_location ->> 'country',
	zip_code = (v_product_location ->> 'zipCode')::bigint
WHERE product_id = v_product_id;

return 'success';
end;
$BODY$;

ALTER FUNCTION public.updateproduct_location(json, bigint)
    OWNER TO postgres;
