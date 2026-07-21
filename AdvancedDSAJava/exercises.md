{\rtf1\ansi\ansicpg1252\cocoartf2870
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\froman\fcharset0 Times-Bold;\f1\fmodern\fcharset0 Courier-Bold;\f2\froman\fcharset0 Times-Roman;
\f3\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;}
{\*\listtable{\list\listtemplateid1\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat0\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid1\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid1}
{\list\listtemplateid2\listhybrid{\listlevel\levelnfc0\levelnfcn0\leveljc0\leveljcn0\levelfollow0\levelstartat1\levelspace360\levelindent0{\*\levelmarker \{decimal\}}{\leveltext\leveltemplateid101\'01\'00;}{\levelnumbers\'01;}\fi-360\li720\lin720 }{\listname ;}\listid2}
{\list\listtemplateid3\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat0\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid201\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid3}
{\list\listtemplateid4\listhybrid{\listlevel\levelnfc23\levelnfcn23\leveljc0\leveljcn0\levelfollow0\levelstartat0\levelspace360\levelindent0{\*\levelmarker \{disc\}}{\leveltext\leveltemplateid301\'01\uc0\u8226 ;}{\levelnumbers;}\fi-360\li720\lin720 }{\listname ;}\listid4}}
{\*\listoverridetable{\listoverride\listid1\listoverridecount0\ls1}{\listoverride\listid2\listoverridecount0\ls2}{\listoverride\listid3\listoverridecount0\ls3}{\listoverride\listid4\listoverridecount0\ls4}}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\sa280\partightenfactor0

\f0\b\fs28 \cf0 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Exercise 1: Unique & Sorted Word Extractor (
\f1\fs30\fsmilli15210 TreeSet
\f0\fs28 )\
\pard\pardeftab720\sa240\partightenfactor0

\fs24 \cf0 Task:
\f2\b0  Write a program that takes a sentence from the user, splits it into words, converts all words to lowercase, removes punctuation, and prints the unique words in alphabetical order.\
\pard\tx220\tx720\pardeftab720\li720\fi-720\sa240\partightenfactor0
\ls1\ilvl0
\f0\b \cf0 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	\uc0\u8226 	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Goal:
\f2\b0  Practice basic 
\f3\fs26 TreeSet
\f2\fs24  operations and automatic sorting/deduplication.\
\pard\pardeftab720\sa280\partightenfactor0

\f0\b\fs28 \cf0 Exercise 2: Student Leaderboard (
\f1\fs30\fsmilli15210 TreeMap
\f0\fs28  + Custom Sorting)\
\pard\pardeftab720\sa240\partightenfactor0

\fs24 \cf0 Task:
\f2\b0  Create a class 
\f3\fs26 Student
\f2\fs24  with attributes 
\f3\fs26 name
\f2\fs24  and 
\f3\fs26 gpa
\f2\fs24 .\
\pard\tx220\tx720\pardeftab720\li720\fi-720\sa240\partightenfactor0
\ls2\ilvl0\cf0 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	1	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Store student objects as 
\f0\b keys
\f2\b0  in a 
\f3\fs26 TreeMap
\f2\fs24  where the value is their major (e.g., 
\f3\fs26 "Computer Science"
\f2\fs24 ).\
\ls2\ilvl0\kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	2	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Pass a custom 
\f3\fs26 Comparator
\f2\fs24  to the 
\f3\fs26 TreeMap
\f2\fs24  constructor so students are automatically sorted in 
\f0\b descending order of GPA
\f2\b0 .\
\pard\tx220\tx720\pardeftab720\li720\fi-720\sa240\partightenfactor0
\ls3\ilvl0
\f0\b \cf0 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	\uc0\u8226 	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Goal:
\f2\b0  Practice using custom 
\f3\fs26 Comparator
\f2\fs24  objects with tree collections.\
\pard\pardeftab720\sa280\partightenfactor0

\f0\b\fs28 \cf0 Exercise 3: Word Frequency & Range Filter (
\f1\fs30\fsmilli15210 TreeMap
\f0\fs28 )\
\pard\pardeftab720\sa240\partightenfactor0

\fs24 \cf0 Task:
\f2\b0  1. Given a long paragraph, count the frequency of each word using a 
\f3\fs26 TreeMap<String, Integer>
\f2\fs24 . 2. Use 
\f3\fs26 .subMap(fromKey, toKey)
\f2\fs24  to print only words starting between 
\f3\fs26 'd'
\f2\fs24  and 
\f3\fs26 'm'
\f2\fs24 .\
\pard\tx220\tx720\pardeftab720\li720\fi-720\sa240\partightenfactor0
\ls4\ilvl0
\f0\b \cf0 \kerning1\expnd0\expndtw0 \outl0\strokewidth0 {\listtext	\uc0\u8226 	}\expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 Goal:
\f2\b0  Leverage key-based navigation methods in 
\f3\fs26 TreeMap
\f2\fs24 .\
}