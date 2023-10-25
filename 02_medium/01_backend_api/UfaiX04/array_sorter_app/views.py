from django.shortcuts import render

# Create your views here.
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework.decorators import api_view


def home(request):
    return render(request, 'home.html')


@api_view(['POST'])
def sort_array(request):
    if request.method == 'POST':
        try:
            data = request.data
            if 'array' in data:
                array_to_sort = data['array']
                sorted_array = sorted(array_to_sort)
                return Response({'sorted_array': sorted_array}, status=status.HTTP_200_OK)
            else:
                return Response({'error': 'Array not provided in the request data'}, status=status.HTTP_400_BAD_REQUEST)
        except Exception as e:
            return Response({'error': str(e)}, status=status.HTTP_500_INTERNAL_SERVER_ERROR)
