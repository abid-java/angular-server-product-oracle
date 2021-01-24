-- FUNCTION: public.updateproduct(json, bigint)

-- DROP FUNCTION public.updateproduct(json, bigint);

CREATE OR REPLACE FUNCTION public.updateproduct(
	v_product json,
	v_product_id bigint)
    RETURNS character varying
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
begin

update products set
	product_name = v_product ->> 'productName',
	description = v_product ->> 'description',
	price = (v_product ->> 'price')::numeric,
	created_at = (v_product ->>'createdAt')::timestamp without time zone
WHERE product_id = v_product_id;

return 'success';
end;
$BODY$;

ALTER FUNCTION public.updateproduct(json, bigint)
    OWNER TO postgres;
