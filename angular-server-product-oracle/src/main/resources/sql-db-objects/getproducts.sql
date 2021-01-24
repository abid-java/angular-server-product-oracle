-- FUNCTION: public.getproducts(bigint)

-- DROP FUNCTION public.getproducts(bigint);

CREATE OR REPLACE FUNCTION public.getproducts(
	v_product_id bigint)
    RETURNS TABLE(product_id bigint, created_at timestamp without time zone, description character varying, price numeric, product_name character varying, address_line_1 character varying, address_line_2 character varying, city character varying, state character varying, country character varying, zip_code bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$
BEGIN
IF v_product_id is not null THEN
RETURN query 
select pr.product_id,
	   pr.created_at,
	   pr.description,
	   pr.price,
	   pr.product_name,
	   pl.address_line_1,
	   pl.address_line_2,
	   pl.city,
	   pl.state,
	   pl.country,
	   pl.zip_code
	   FROM products pr INNER JOIN product_locations pl ON pr.product_id=pl.pc_fid
	   WHERE pc_fid=v_product_id;	   
ELSE 
RETURN query
SELECT pr.product_id,
	   pr.created_at,
	   pr.description,
	   pr.price,
	   pr.product_name,
	   pl.address_line_1,
	   pl.address_line_2,
	   pl.city,
	   pl.state,
	   pl.country,
	   pl.zip_code
	   FROM products pr INNER JOIN product_locations pl ON pr.product_id=pl.pc_fid;
END IF;
END;
$BODY$;

ALTER FUNCTION public.getproducts(bigint)
    OWNER TO postgres;
