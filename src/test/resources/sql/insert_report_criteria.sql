DELETE FROM report_criteria;
DELETE FROM report;

INSERT INTO report (film_id, film_name, character_id, character_name, planet_id, planet_name) VALUES
  ('6', 'Revenge of the Sith', '5', 'Leia Organa', '2', 'Alderaan');

INSERT INTO report_criteria (report_criteria_id, film_id, character_id, planet_id) VALUES
  ('1', '6', '5', '2');