

(defun LEN (L)
  (cond ((atom L) 0)
	('T (+ 1 (LEN (cdr L))))
	))

(defun TAKE (N L)
  (cond ((atom L) ())
	((eq N 0) ())
	('T       (cons (car L) (TAKE (- N 1) (cdr L))))
	)
  )

(defun DROP (N L)
  (cond ((atom L) ())
	((> N 0)  (DROP (- N 1) (cdr L)))
	('T L)
	)
  )

(defun HALVE (N) (FLOOR  N 2))

; TAKES TWO SORTED ARRAYS
(defun MERGE_ (predicate L1 L2)
  (cond ((atom L1) L2)
	((atom L2) L1)
	((funcall predicate (car L1) (car L2))  (cons (car L1) (MERGE_ predicate (cdr L1) L2)))
	('T                                     (cons (car L2) (MERGE_ predicate  L1 (cdr L2))))
	)
  )
(defun MERGESORT (predicate L) 
  ( cond ((atom L) ())
	 ((atom (cdr L)) L)
	 ('T       (MERGE_ predicate (MERGESORT predicate (TAKE (HALVE (LEN L)) L)) 
			             (MERGESORT predicate (DROP (HALVE (LEN L)) L))))
	)
  )
  
