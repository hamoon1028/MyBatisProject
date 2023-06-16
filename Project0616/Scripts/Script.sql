CREATE TABLE EMP AS SELECT * FROM EMPLOYEES e ;
CREATE TABLE DEPT AS SELECT * FROM DEPARTMENTS;
CREATE TABLE JOB2 AS SELECT * FROM JOBS;


-- 전체조회
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, MANAGER_ID, JOB_ID, DEPARTMENT_ID
	FROM EMP;

-- 사원등록, employee_id 중복제거
INSERT INTO EMP (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, MANAGER_ID, JOB_ID, DEPARTMENT_ID)
	VALUES((SELECT MAX(EMPLOYEE_ID)+1
				FROM EMP)
			,'MOON','HAMOON',SYSDATE,'IT_PROG','10');

-- employee_id 중복제거
SELECT MAX(EMPLOYEE_ID)+1
	FROM EMP;

-- 사원 삭제
DELETE FROM EMP e 
	WHERE EMPLOYEE_ID = '207';

SELECT *
	FROM EMP e 
	WHERE EMPLOYEE_ID = '204';

-- 직원 급여 갱신
UPDATE EMP SET SALARY = '5000'
	WHERE EMPLOYEE_ID = '204';


SELECT JOB_ID, MIN_SALARY, MAX_SALARY
	FROM JOBS;

--직업별 급여 조회
 SELECT EMPLOYEE_ID, e.JOB_ID, SALARY, 평균급여
 	FROM EMP e, (SELECT JOB_ID, AVG(SALARY) 평균급여
				 	FROM EMP e 
				 	GROUP BY JOB_ID) e2
	WHERE e.JOB_ID = e2.JOB_ID
		AND EMPLOYEE_ID = '103';


 SELECT JOB_ID, AVG(SALARY)
 	FROM EMP e 
 	GROUP BY JOB_ID ;
	
-- SALARY를 업데이트할 때 JOBS의 최소급여 최대급여 안에서만 갱신되도록 처리하는 트리거
CREATE OR REPLACE TRIGGER TRG_EMP_SALARY
BEFORE UPDATE ON EMP
FOR EACH ROW
DECLARE
    V_MIN_SALARY JOBS.MIN_SALARY%TYPE;
    V_MAX_SALARY JOBS.MAX_SALARY%TYPE;
BEGIN
    SELECT MIN_SALARY, MAX_SALARY INTO V_MIN_SALARY, V_MAX_SALARY
    FROM JOB2 WHERE JOB_ID = :NEW.JOB_ID;

    IF :NEW.SALARY < V_MIN_SALARY OR :NEW.SALARY > V_MAX_SALARY THEN
        RAISE_APPLICATION_ERROR(-20001, '사이 값이 아닙니다');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, '해당 JOB_ID에 대한 레코드가 JOBS 테이블에 없습니다');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20003, 'ERROR');
END;

DROP TRIGGER TRG_EMP_SALARY;

-- JOBS의 JOB_ID를 갱신시 EMPLOYEES의 JOB_ID도 갱신되도록하는 트리거
CREATE OR REPLACE TRIGGER TRG_UPDATE_JOB2_EMP_ID
BEFORE UPDATE OF JOB_ID ON JOB2
FOR EACH ROW
BEGIN
    UPDATE EMP
    SET JOB_ID = :NEW.JOB_ID
    WHERE JOB_ID = :OLD.JOB_ID;
END;

-- 사원의 부서 이름 조회
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, DEPARTMENT_NAME
	FROM DEPT  JOIN EMP 
	USING(DEPARTMENT_ID)
	WHERE EMPLOYEE_ID = '103';

-- 사원의 직업 이름 조회
SELECT JOB_ID, JOB_TITLE
	FROM JOB2 JOIN EMP 
	USING(JOB_ID)
	WHERE EMPLOYEE_ID = '207';

-- 사원의 매니저 조회
SELECT e.EMPLOYEE_ID , e.FIRST_NAME , e2.EMPLOYEE_ID AS MANAGER_ID, e2.LAST_NAME AS MANAGER
	FROM EMP e , EMP e2 
	WHERE e.MANAGER_ID = e2.EMPLOYEE_ID
	AND e.EMPLOYEE_ID = '207';




