v0.1
added image view

v0.2
changed voice command
added screenshots

v0.3
forgot to update readme
gps acquisition is based on cell network signal and gps of companion phone.
multithreading used to refresh gps coordinates approximately every 5 seconds
notes for the future:
change imageview into canvasview; image view is not ideal, or unable to produce maps

v0.4
changed imageview to canvas to allow drawing on canvas

v0.5
attempt to fix layout (WIP)
added screenshots

v0.6
attempted to fix layout for long amount of time only to find out cardbuilder was messing with me
main page layout fixed
fix

v0.7
having trouble finding out right resolution for bitmap conversion, bitmaps have a max resolution of 2048x2048 to display on glass
experimenting with different resolutions of jpg to bmp conversions.
1.6k by something that is jpg = rescale to 5/6

v0.7a
temporary fix for map, used a downscaled map for displaying, will probably turn into tiled bitmap in the future

v0.7b
when coordinates are input into the position finder, area is accurate but not accurate enough, 
either increase resolution of map or calibrate coordinates more.

OPTIONAL PENDING:
tiled bitmap for world map of dlsu, for better zoom and resolution


NOTES:
Current Map Resolution is 1168, 531
	
A(Upper Left) @ 280, 120 
B(Lower Left) @ 280, -673
C(Lower Right) @ -1468, -673
D(Upper Right) @ -1468, 120 

when i input 0,0; i will go to 280, 120

A
14.563079, 120.992789
B
14.563801, 120.994485
C
14.567616, 120.992851
D
14.566777, 120.990966 

x min = 14.563079
x ave = 14.5653475
x max = 14.567616

x max - x min = 0.004537 //coordinates between

y min = 120.990966
y ave = 120.992725
y max = 120.994485

y max - y min = 0.003519 //coordinates between

Image Resolution
1749, 794

Test Coordinates, velasco side zaide
14.565463, 120.992841 - velasco side zaide
14.565158, 120.993571 - henry sy grass center
14.564045, 120.993678 - marian quad

x current - x min = x delta

14.565463 - 14.563079 = 0.002384

x delta / x between = percentage?

0.002384 / 0.004537 = 0.5254535

image max * percentage = place in map?

y current - y min = y delta

120.992841 - 120.990966 = 0.001875

y delta / y between = percentage?

0.001875 / 0.003519 = 0.5328218
