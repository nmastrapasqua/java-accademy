select * from name_basics nb where nb.nconst ='nm0408348';

select * from title_principals tp where tp.nconst  ='nm0000018';

select * from title_basics tb 
join title_principals tp on tp.tconst = tb.tconst
where tp.nconst = 'nm0408348' -- 'nm0000018';



-- Per selezionare un pò di dati
select nconst, birthYear as birth_year, deathYear as death_year,
primaryName as primary_name
from name_basics
where nconst in (
	select nconst from title_principals tp 
	where tp.tconst in
	(
		select tconst from title_basics where genres like 'Action%' or genres like 'Fantasy%')
	) 
limit 200;



select tconst, originalTitle, runtimeMinutes, genres, startYear  
from title_basics where genres like 'Action%' or genres like 'Fantasy%'
limit 200;